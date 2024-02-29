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

import java.util.ArrayList;
import java.util.List;

/**
 * Simple Builder of {@link IR}.
 * @since 0.1
 * @checkstyle AbbreviationAsWordInNameCheck (5 lines)
 */
public final class IRSimpleBuilder implements IRBuilder {

    /**
     * List of bound attributes.
     */
    private final List<BoundAttribute> attrs;

    /**
     * Ctor.
     */
    public IRSimpleBuilder() {
        this.attrs = new ArrayList<>(0);
    }

    @Override
    public IRSimpleBuilder with(final String name, final Expression expression) {
        this.with(new BoundAttribute(name, expression));
        return this;
    }

    @Override
    public IRSimpleBuilder with(final BoundAttribute bound) {
        this.attrs.add(bound);
        return this;
    }

    @Override
    public Link getLinkTo(final String name) {
        final Attribute source = this.attrs.stream().filter(
            attr -> name.equals(attr.name())
        ).findFirst().orElseThrow(
            () -> new IllegalArgumentException(
                String.format("No attribute %s found", name)
            )
        );
        return new Link(source);
    }

    @Override
    public IR build() {
        return new IR(this.attrs);
    }
}
