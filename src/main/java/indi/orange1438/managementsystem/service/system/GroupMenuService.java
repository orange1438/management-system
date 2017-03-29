package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.GroupMenuDAO;
import indi.orange1438.managementsystem.dao.entity.GroupMenu;
import indi.orange1438.managementsystem.dao.entity.GroupMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件描述注释
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/27 17:15
 */
@Service
public class GroupMenuService {

    @Autowired
    GroupMenuDAO groupMenuDAO;


    /**
     * 根据组ID删除
     *
     * @param groupId
     * @return
     */
    public int deleteGroupMenuByGroupId(Long groupId) throws Exception {
        GroupMenuExample groupMenuExample = new GroupMenuExample();
        groupMenuExample.createCriteria().andGroupIdEqualTo(groupId);
        return groupMenuDAO.deleteByExample(groupMenuExample);
    }

    /**
     * 批量插入GroupMenu,(可优化)
     */
    public int insertGroupMenu(Long groupId, List<GroupMenu> groupMenuList) throws Exception {
        // 先删除，再添加
        deleteGroupMenuByGroupId(groupId);

        for (GroupMenu groupMenu : groupMenuList) {
            groupMenuDAO.insertSelective(groupMenu);
        }
        return 1;
    }
}
