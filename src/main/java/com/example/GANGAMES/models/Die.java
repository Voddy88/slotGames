package com.example.GANGAMES.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Die {
    private int value;

    public Die(int value){
        this.value = value;
    }
}
