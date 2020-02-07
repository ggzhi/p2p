package com.xmg.p2p.base.util;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * 用来标记登录的标签
 * @author 14847
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireLogin {

}
