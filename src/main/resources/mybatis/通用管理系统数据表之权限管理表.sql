CREATE TABLE `SYS_MENU` (`MENU_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单ID',`MENU_NAME` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '菜单名称',`MENU_URL` VARCHAR(255) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '菜单URL',`PARENT_ID` BIGINT(20) UNSIGNED NULL DEFAULT NULL COMMENT '父菜单ID',`MENU_ICON` VARCHAR(32) CHARACTER SET UTF8 NULL COMMENT '菜单图标名',`MENU_TYPE` VARCHAR(16) NULL COMMENT '菜单类型{1系统、2业务}',`MENU_ORDER` INT UNSIGNED NULL DEFAULT 0 COMMENT '排序',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`MENU_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='菜单表';CREATE TABLE `SYS_PERMISSION` (`PERMISSION_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限ID',`PERMISSION_NAME` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '权限名',`DESCRIPTION` VARCHAR(100) CHARACTER SET UTF8 NULL COMMENT '权限描述',`ADD_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '添加权限:1表示能，0表示不能',`ADD_TITLE` VARCHAR(32) NULL COMMENT 'ADD标题',`DELETE_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '删除权限:1表示能，0表示不能',`DELETE_TITLE` VARCHAR(32) NULL COMMENT 'DELETE标题',`EDIT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '编辑权限:1表示能，0表示不能',`EDIT_TITLE` VARCHAR(32) NULL COMMENT 'EDIT标题',`VIEW_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '查看详细权限:1表示能，0表示不能',`VIEW_TITLE` VARCHAR(32) NULL COMMENT 'VIEW标题',`IMPORT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '导入权限:1表示能，0表示不能',`IMPORT_TITLE` VARCHAR(32) NULL COMMENT 'IMPORT标题',`EXPORT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '导出权限:1表示能，0表示不能',`EXPORT_TITLE` VARCHAR(32) NULL COMMENT 'EXPORT标题',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`PERMISSION_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='权限点许可表';CREATE TABLE `SYS_PERMISSION_MENU` (`PERMISSION_MENU_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限菜单关系ID',`PERMISSION_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限ID',`MENU_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单ID',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`PERMISSION_MENU_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='权限菜单关联表';CREATE TABLE `SYS_ROLE` (`ROLE_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',`ROLE_NAME` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '角色名',`DESCRIPTION` VARCHAR(100) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '角色描述',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`ROLE_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='角色表';CREATE TABLE `SYS_USER` (`USER_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '用户ID',`USER_NAME` VARCHAR(16) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '账户名',`PASSWORD` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '账户密码',`IS_DISABLED` VARCHAR(1) CHARACTER SET UTF8 NULL DEFAULT 0 COMMENT '是否禁用',`PARENT_ID` BIGINT(20) UNSIGNED NULL COMMENT '父级账号ID',`TRUE_NAME` VARCHAR(20) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '真实姓名',`MOBILE` VARCHAR(16) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '手机号',`EMAIL` VARCHAR(64) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '电子邮箱',`SKIN` VARCHAR(20) CHARACTER SET UTF8 NULL DEFAULT 'DEFAULT' COMMENT '皮肤',`LAST_LOGIN_TIME` TIMESTAMP NULL DEFAULT NULL COMMENT '上次登录时间',`LOGIN_IP` VARCHAR(40) CHARACTER SET UTF8 NULL COMMENT '登录IP（支持IPV4、IPV6）',`LOGIN_COUNT` BIGINT(20) UNSIGNED NULL DEFAULT 0 COMMENT '登录次数',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`USER_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='系统用户表';CREATE TABLE `SYS_GROUP` (`GROUP_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '组ID',`GROUP_NAME` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NOT NULL COMMENT '组名',`DESCRIPTION` VARCHAR(100) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '组描述',`PARENT_ID` BIGINT(20) UNSIGNED NULL COMMENT '父组ID',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`GROUP_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='组表';CREATE TABLE `SYS_ROLE_GROUP` (`ROLE_GROUP_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '角色组关系ID',`ROLE_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',`GROUP_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '组ID',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`ROLE_GROUP_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='角色与组的关联表';CREATE TABLE `SYS_USER_ROLE` (`USER_ROLE_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '用户角色关系ID',`ROLE_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',`USER_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限ID',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`USER_ROLE_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='用户角色关联表';CREATE TABLE `SYS_GROUP_MENU` (`GROUP_MENU_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单组关系ID',`GROUP_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '组ID',`MENU_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '菜单ID',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`GROUP_MENU_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='菜单与组的关联表';CREATE TABLE `SYS_ROLE_PERMISSION` (`ROLE_PERMISSION_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限ID',`ROLE_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',`PERMISSION_ID` BIGINT(20) UNSIGNED NOT NULL COMMENT '权限ID',`ADD_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '添加权限:1表示能，0表示不能',`DELETE_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '删除权限:1表示能，0表示不能',`EDIT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '编辑权限:1表示能，0表示不能',`VIEW_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '查看详细权限:1表示能，0表示不能',`IMPORT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '导入权限:1表示能，0表示不能',`EXPORT_RIGHTS` TINYINT(1) NULL DEFAULT 1 COMMENT '导出权限:1表示能，0表示不能',`CREATE_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',`CREATOR` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '创建人',`MODIFY_TIME` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',`MODIFIER` VARCHAR(32) CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI NULL DEFAULT NULL COMMENT '修改人',PRIMARY KEY (`ROLE_PERMISSION_ID`))ENGINE=INNODBDEFAULT CHARACTER SET=UTF8 COLLATE=UTF8_GENERAL_CICOMMENT='角色权限表';