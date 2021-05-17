package cn.cherryrental.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapHouseDataResult {
    private List<MapHouseXY> list;
}
