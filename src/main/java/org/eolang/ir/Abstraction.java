/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2024 Objectionary.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.eolang.ir;

import java.util.List;

/**
 * Abstraction.
 * @since 0.1
 */
public final class Abstraction extends Expression {

    /**
     * Frees.
     */
    private final List<FreeAttribute> frees;

    /**
     * Bounds.
     */
    private final List<BoundAttribute> bounds;

    /**
     * Ctor.
     * @param frees Frees.
     * @param bound Bound.
     */
    public Abstraction(final List<FreeAttribute> frees, final List<BoundAttribute> bound) {
        this.frees = frees;
        this.bounds = bound;
    }

    @Override
    @SuppressWarnings("PMD.AppendCharacterWithChar")
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        this.frees.forEach(att -> builder.append(att.name()).append(" "));
        builder.append("]\n");
        this.bounds.forEach(
            att -> {
                final String[] lines = att.toString().split("\n");
                for (final String line : lines) {
                    builder.append(' ').append(line).append("\n");
                }
            }
        );
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
