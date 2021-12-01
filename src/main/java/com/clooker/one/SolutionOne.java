package com.clooker.one;

import com.clooker.Solution;

import java.util.List;
import java.util.stream.IntStream;

abstract class SolutionOne extends Solution {

    protected SolutionOne(String inputFile) {
        super(inputFile);
    }

    @Override
    public final Number get() {
        List<Integer> depths = getDepths();

        return IntStream
                .range(1, depths.size())
                .filter(i -> depths.get(i) > depths.get(i - 1))
                .count();
    }

    abstract List<Integer> getDepths();
}
