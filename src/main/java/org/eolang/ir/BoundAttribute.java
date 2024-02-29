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

/**
 * BoundAttribute.
 * @since 0.1
 */
public final class BoundAttribute implements Attribute {

    /**
     * Name.
     */
    @SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
    private final String name;

    /**
     * Left.
     */
    private final Expression left;

    /**
     * Ctor.
     * @param name Name.
     * @param left Left.
     */
    public BoundAttribute(final String name, final Expression left) {
        this.name = name;
        this.left = left;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    @SuppressWarnings("PMD.AppendCharacterWithChar")
    public String toString() {
        final String[] lefts = this.left.toString().split("\n");
        final StringBuilder builder = new StringBuilder();
        builder.append(lefts[0]).append(" > ").append(this.name).append("\n");
        if (lefts.length > 1) {
            for (int ind = 1; ind < lefts.length; ++ind) {
                builder.append("").append(lefts[ind]).append("\n");
            }
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}
