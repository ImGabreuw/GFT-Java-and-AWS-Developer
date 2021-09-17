package me.gabreuw.restful.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Tribe {

    HUMAN("humano"),
    ELF("elfo"),
    ORC("orc"),
    DWARF("anão");

    private final String name;

    public static Tribe of(String tribeName) {
        return Arrays.stream(Tribe.values())
                .filter(tribe -> tribe.getName().equalsIgnoreCase(tribeName))
                .findFirst()
                .orElseThrow();
    }

}
