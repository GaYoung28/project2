package com.shinsegae.project.inventory.mapper;

import com.shinsegae.project.inventory.vo.InventoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
    List<InventoryVO> selectInventoryAll();
}