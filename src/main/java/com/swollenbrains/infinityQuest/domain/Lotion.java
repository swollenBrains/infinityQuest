package com.swollenbrains.infinityQuest.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Lotion implements Serializable {

    private Integer health;

}
