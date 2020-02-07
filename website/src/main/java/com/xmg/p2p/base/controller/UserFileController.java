package com.xmg.p2p.base.controller;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xmg.p2p.base.domain.UserFile;
import com.xmg.p2p.base.service.ISystemDictionaryService;
import com.xmg.p2p.base.service.IUserFileService;
import com.xmg.p2p.base.util.JSONResult;
import com.xmg.p2p.base.util.UploadUtil;
import com.xmg.p2p.base.util.UserContext;

/**
 * 风控资料相关
 * @author 14847
 *
 */
@Controller
public class UserFileController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private IUserFileService userFileService;
	
	
	@Autowired
	private ISystemDictionaryService systemDictionaryService;
	
	@RequestMapping("userFile")
	public String userFile(Model model, HttpServletRequest request) {
		List<UserFile> userFiles = this.userFileService.listFilesByHasType(
				UserContext.getCurrent().getId(), false);
		// 有没有选择的用户文件类型,设置数据字典,并往userFiles_commit
		if (userFiles.size() > 0) {
			model.addAttribute("fileTypes",
					this.systemDictionaryService.listByParentSn("userFileType"));
			model.addAttribute("userFiles", userFiles);
			return "userFiles_commit";
		} else {
			// 选择所有该用户的风控文件
			// 网userfile
			model.addAttribute("sessionid", request.getSession().getId());
			userFiles = this.userFileService.listFilesByHasType(UserContext
					.getCurrent().getId(), true);
			model.addAttribute("userFiles", userFiles);
			return "userFiles";
		}
	}
	/**
	 * 处理上传用户风控文件
	 */
	@RequestMapping("userFileUpload")
	@ResponseBody
	public void userFileUpload(MultipartFile file) {
		String basePath = this.servletContext.getRealPath("/upload");
		String fileName = UploadUtil.upload(file, basePath);
		fileName = "/upload/" + fileName;
		this.userFileService.apply(fileName);
	}

	/**
	 * 处理用户风控文件类型选择
	 */
	@RequestMapping("userFile_selectType")
	@ResponseBody
	public JSONResult userFileSelectType(Long[] fileType, Long[] id) {
		if (fileType != null && id != null && fileType.length == id.length) {
			this.userFileService.batchUpdateFileType(id, fileType);
		}
		return new JSONResult();
	}
}
