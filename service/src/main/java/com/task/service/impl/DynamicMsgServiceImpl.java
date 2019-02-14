package com.task.service.impl;

import com.task.dao.DynamicMsgMapper;
import com.task.pojo.DynamicMsg;
import com.task.pojo.Star;
import com.task.service.DynamicMsgService;
import com.task.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dynamicMsgService")
@Transactional
public class DynamicMsgServiceImpl extends BaseServiceImpl<DynamicMsg> implements DynamicMsgService {
    @Autowired
    private DynamicMsgMapper mapper;
    @Autowired
    private StarService starService;

    @Override
    public void updateObject(DynamicMsg object) {
        if (object.getStar()!=null){
            Star star = new Star();
            star.setM_id(object.getId());
            star.setU_id(object.getU_id());
            if (object.getStar()==1){
                starService.addObject(star);
            }else{
                starService.deleteObjectById(star);
            }
        }
        super.updateObject(object);
    }
}
