package com.example.GANGAMES.DTO;

import com.example.GANGAMES.models.Die;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class CrapsSingleGameResponse extends BaseGameResponse{

    private Map<Integer,Die[]> details = new LinkedHashMap<>();
}
