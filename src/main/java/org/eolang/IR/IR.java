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
package org.eolang.IR;

import java.util.List;

/**
 * IR.
 * @since 0.1
 */
public final class IR implements Node {

    /**
     * Attrs.
     */
    private final List<BoundAttribute> attrs;

    /**
     * Ctor.
     * @param attributes Array of objects.
     */
    public IR(final List<BoundAttribute> attributes) {
        this.attrs = attributes;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final BoundAttribute attr: this.attrs) {
            builder.append(attr);
            builder.append("\n");
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }
}