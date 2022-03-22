package com.assignment.service;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sabbir on 3/22/22.
 */
public class SolutionServiceImplTest {

    private SolutionServiceIF solution;

    @Before
    public void setUp() throws Exception {
        solution = new SolutionServiceImpl();
    }

    @Test
    public void generateFile() throws Exception {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("----- Before service calling -> memory usage: " + beforeUsedMem);

        solution.generateFile(100);

        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("----- After service calling -> memory usage: " + afterUsedMem);

        long actualMemUsed = afterUsedMem-beforeUsedMem;
        System.out.println("----- Actual memory usage: " + actualMemUsed);
    }
}