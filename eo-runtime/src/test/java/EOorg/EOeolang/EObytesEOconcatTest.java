/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2023 Objectionary.com
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

/*
 * @checkstyle PackageNameCheck (10 lines)
 */
package EOorg.EOeolang;

import org.eolang.Data;
import org.eolang.Dataized;
import org.eolang.PhMethod;
import org.eolang.PhWith;
import org.eolang.Phi;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

/**
 * Test case for {@link EObytes}.
 *
 * @since 0.23
 * @checkstyle TypeNameCheck (4 lines)
 */
final class EObytesEOconcatTest {

    @Test
    void concatenatesBytes() {
        final Phi current = new EOstring$EOas_bytes(new Data.ToPhi("привет "));
        final Phi provided = new EOstring$EOas_bytes(new Data.ToPhi("mr. ㄤㄠ!"));
        final Phi phi = new PhMethod(
            new PhWith(
                new EObytes$EOconcat(current),
                "b",
                provided
            ),
            "as-string"
        );
        MatcherAssert.assertThat(
            new Dataized(phi.copy()).take(String.class),
            Matchers.equalTo("привет mr. ㄤㄠ!")
        );
    }

}
