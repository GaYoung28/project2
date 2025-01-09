package com.shinsegae.project.inventory.service;

import com.shinsegae.project.inventory.mapper.InventoryMapper;
import com.shinsegae.project.inventory.vo.InventoryManagementDTO;
import com.shinsegae.project.inventory.vo.InventoryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryMapper inventoryMapper;

    public List<InventoryManagementDTO> selectInventoryAll() {
        return inventoryMapper.selectInventoryAll();
    }

    public Map<String, Integer> getSum(List<InventoryManagementDTO> list){
        Map<String, Integer> map = new HashMap<>(); // 키 - 값 쌍으로 데이터 저장 인터페이스

        int sum1 = 0; //900
        int sum2 = 0; //1000

        for (InventoryManagementDTO dto : list) {
            sum1 += dto.getPrice();
        }

        map.put("sum1", sum1);

        for (InventoryManagementDTO dto : list) {
            sum2 += dto.getStock();
        }

        map.put("sum2", sum2);

        return map; //{900, 1000}
    }
    public List<InventoryManagementDTO> getInventoryByContent() {
        return inventoryMapper.getInventoryByContent();
    }

    public int updateInventory(InventoryManagementDTO inventoryManagementDTO) {
        return inventoryMapper.updateInventory(inventoryManagementDTO);
    }

    public int insertInventory(InventoryManagementDTO inventoryManagementDTO) {
        return inventoryMapper.insertInventory(inventoryManagementDTO);
    }

    public int deleteInventory(int product_code) {
        return inventoryMapper.deleteInventory(product_code);
    }

}