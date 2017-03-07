<!-- 本页面涉及的js函数，都在head.jsp页面中 -->
<div id="sidebar" class="menu-min">

    <ul class="nav nav-list">

        <li class="active" id="fhindex">
            <a href="/main/index"><i class="icon-dashboard"></i><span>后台首页</span></a>
        </li>

        <c:forEach var="menu" items="${menuList}">
            <c:if test="${menu.hasMenu}">
                <li id="lm${menu.menuId }">
                    <a style="cursor:pointer;" class="dropdown-toggle">
                        <i class="${menu.menuIcon == null ? 'icon-desktop' : menu.menuIcon}"></i>
                        <span>${menu.menuName}</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <c:forEach var="sub" items="${menu.subMenu}">

                                <c:choose>
                                    <c:when test="${not empty sub.menuUrl}">
                                        <li id="z${sub.menuId }">
                                            <a style="cursor:pointer;" target="mainFrame"
                                               onclick="siMenu('z${sub.menuId}','lm${menu.menuId}','${sub.menuName}','${sub.menuUrl}')">
                                                <i class="icon-double-angle-right"></i>${sub.menuName}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <i class="icon-double-angle-right"></i>${sub.menuName}
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>

                        </c:forEach>
                    </ul>
                </li>
            </c:if>
        </c:forEach>

    </ul><!--/.nav-list-->

    <div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>

</div>
<!--/#sidebar-->

