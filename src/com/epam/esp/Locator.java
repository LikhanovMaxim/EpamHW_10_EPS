package com.epam.esp;

import java.util.Map;

public interface Locator {
    Map<RiskGroup, Integer> findOutSituation(Sector sector);

    String toStringGroups();
}
