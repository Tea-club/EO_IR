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
import org.cactoos.list.ListOf;
import org.junit.jupiter.api.Test;

/**
 * Just demo.
 * @since 0.1
 * @checkstyle LocalFinalVariableNameCheck (500 lines)
 */
public class IRdemoTest {

    @Test
    void buildsSimpleEO() {
        final IRBuilder builder = new IRSimpleBuilder();
        builder.with("world", new Abstraction(new ArrayList<>(0), new ArrayList<>(0)));
        final Link world = builder.getLinkTo("world");
        builder.with(
            "person",
            new Abstraction(
                new ArrayList<>(0),
                new ListOf<>(
                    new BoundAttribute("@", world)
                )
            )
        );
        final IR build = builder.build();
        System.out.println(build);
        System.out.println();
    }

    @Test
    void romanKorostinskiy() {
        final IRBuilder builder = new IRSimpleBuilder();
        builder.with("world", new Abstraction(new ArrayList<>(0), new ArrayList<>(0)));
        final Link world = builder.getLinkTo("world");
        builder.with("obj1", new Abstraction(new ArrayList<>(0), new ArrayList<>(0)));
        final Link obj1 = builder.getLinkTo("obj1");
        builder.with("obj2", new Abstraction(new ArrayList<>(0), new ArrayList<>(0)));
        final Link obj2 = builder.getLinkTo("obj2");
        builder.with("obj3", new Abstraction(new ArrayList<>(0), new ArrayList<>(0)));
        final Link obj3 = builder.getLinkTo("obj3");
        builder.with(
            "person",
            new Abstraction(
                new ArrayList<>(0),
                new ListOf<>(
                    new BoundAttribute(
                        "@",
                        new DotNotation(
                            new Application(world, new ListOf<>(obj1)),
                            new Application(obj2, new ListOf<>(obj3))
                        )
                    )
                )
            )
        );
        builder.with(
            "person2",
            new Abstraction(
                new ArrayList<>(0),
                new ListOf<>(
                    new BoundAttribute("@", new Application(obj1, new ListOf<>(obj2, obj3)))
                )
            )
        );
        final IR build = builder.build();
        System.out.println(build);
    }
}
