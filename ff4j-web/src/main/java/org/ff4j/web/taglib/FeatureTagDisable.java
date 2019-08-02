package org.ff4j.web.taglib;

/*
 * #%L
 * ff4j-web
 * %%
 * Copyright (C) 2013 - 2014 Ff4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.ff4j.FF4j;
import org.ff4j.core.FlippingExecutionContext;

/**
 * Content of enclosing tag will be displayed if feature not enable.
 *
 * <p/>
 *
 * It is also possible to store the result of feature evaluation to be able to use it in a more complex
 * condition:
 *
 * <pre><code>
 *     &lt;ff4j:disable featureid="mercure-desc" var="mercureDescDisabled"&gt;
 *     &lt;c:if test=${mercureDescDisabled && otherCondition}"&gt;
 *       Your HTML code
 *     &lt;/c:if"&gt;
 * </code></pre>
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class FeatureTagDisable extends AbstractFeatureTag {

    /** serial. */
    private static final long serialVersionUID = 2699259876617318061L;

    @Override
    protected boolean evalWithExecutionContext(FF4j ff4j, PageContext pageContext, FlippingExecutionContext executionContext) {
        return !ff4j.check(getFeatureid(), executionContext);
    }
}