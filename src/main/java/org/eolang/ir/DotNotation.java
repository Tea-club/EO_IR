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
 * DotNotation.
 * @since 0.1
 */
public final class DotNotation extends Expression {

    /**
     * Left part, source.
     */
    private final Expression left;

    /**
     * Attribute that is retrieved from source.
     */
    private final Expression right;

    /**
     * Ctor.
     * @param left Source.
     * @param right Attribute.
     */
    public DotNotation(final Expression left, final Expression right) {
        this.left = left;
        this.right = right;
    }

    // @checkstyle LocalFinalVariableNameCheck (30 lines)
    @Override
    @SuppressWarnings({"PMD.AppendCharacterWithChar", "PMD.ConsecutiveLiteralAppends"})
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        final String[] rightLines = this.right.toString().split("\n");
        builder.append(".").append(rightLines[0]);
        final String[] leftLines = this.left.toString().split("\n");
        for (final String line: leftLines) {
            builder.append("\n").append("  ").append(line);
        }
        for (int ind = 1; ind < rightLines.length; ++ind) {
            builder.append("\n").append(rightLines[ind]);
        }
        return builder.toString();
    }
}
