package net.minestom.server.utils.collection;

import org.jetbrains.annotations.ApiStatus;

import java.util.AbstractList;
import java.util.function.IntFunction;

@ApiStatus.Internal
public final class IntMappedArray<R> extends AbstractList<R> {
    private final int[] elements;
    private final IntFunction<R> function;

    public IntMappedArray(int[] elements, IntFunction<R> function) {
        this.elements = elements;
        this.function = function;
    }

    @Override
    public R get(int index) {
        final int[] elements = this.elements;
        if (index < 0 || index >= elements.length)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + elements.length);
        return function.apply(elements[index]);
    }

    @Override
    public int size() {
        return elements.length;
    }
}
