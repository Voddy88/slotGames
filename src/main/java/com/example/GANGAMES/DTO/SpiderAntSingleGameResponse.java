package com.example.GANGAMES.DTO;


import com.example.GANGAMES.game.SpiderDirection;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class SpiderAntSingleGameResponse extends BaseGameResponse {

    private Map<Integer, SpiderDirection> details = new LinkedHashMap<>();
}
