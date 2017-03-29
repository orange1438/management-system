package indi.orange1438.managementsystem.service.system;

import indi.orange1438.managementsystem.dao.GroupDAO;
import indi.orange1438.managementsystem.dao.GroupMenuDAO;
import indi.orange1438.managementsystem.dao.entity.Group;
import indi.orange1438.managementsystem.dao.entity.GroupExample;
import indi.orange1438.managementsystem.dao.entity.GroupMenuExample;
import indi.orange1438.managementsystem.dao.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组服务
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/16 10:47
 */
@Service
public class GroupService {

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    GroupMenuDAO groupMenuDAO;

    /**
     * 得到所有组
     */
    public List<Group> getAllGroup() throws Exception {
        GroupExample groupExample = new GroupExample();
        return groupDAO.selectByExample(groupExample);
    }

    /**
     * 通过 groupId 得到组
     */
    public Group getGroupByGroupId(Long groupId) throws Exception {
        return groupDAO.selectByPrimaryKey(groupId);
    }

    /**
     * 添加组
     *
     * @param group 添加的实体类，必须包括主键
     */
    public int insertGroup(Group group) throws Exception {
        return groupDAO.insertSelective(group);
    }

    /**
     * 更新组
     *
     * @param group 添加的实体类，必须包括主键
     */
    public int updateGroup(Group group) throws Exception {
        return groupDAO.updateByPrimaryKeySelective(group);
    }

    /**
     * 删除组
     */
    public int deleteGroup(Long groupId) throws Exception {
        GroupMenuExample groupMenuExample = new GroupMenuExample();
        groupMenuExample.createCriteria().andGroupIdEqualTo(groupId);
        groupMenuDAO.deleteByExample(groupMenuExample);
        return groupDAO.deleteByPrimaryKey(groupId);
    }
}
