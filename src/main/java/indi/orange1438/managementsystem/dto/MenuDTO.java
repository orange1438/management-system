package indi.orange1438.managementsystem.dto;


import java.util.List;

/**
 * 菜单传输对象
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/06 22:40
 */
public class MenuDTO {
    // 菜单ID
    private Long menuId;

    // 菜单名称
    private String menuName;

    // 菜单URL
    private String menuUrl;

    // 父菜单ID
    private Long parentId;

    // 菜单图标名
    private String menuIcon;

    // 排序  默认：0
    private Integer menuOrder;

    // 子菜单
    private List<MenuDTO> subMenu;

    private boolean hasMenu = false;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public List<MenuDTO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<MenuDTO> subMenu) {
        this.subMenu = subMenu;
    }

    public boolean isHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(boolean hasMenu) {
        this.hasMenu = hasMenu;
    }
}
