/*
 * (C) Copyright 2006-2010 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     bstefanescu
 */
package org.nuxeo.connect.update.xml;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;
import org.nuxeo.connect.update.model.Field;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
@XObject
public class FieldDefinition implements Field {

    @XNode("@name")
    protected String name;

    @XNode("@type")
    protected String type;

    @XNode("@required")
    protected boolean isRequired;

    @XNode("@vertical")
    protected boolean isVertical;

    @XNode("@readonly")
    protected boolean isReadOnly;

    @XNode("label")
    protected String label;

    @XNode("value")
    protected String value;

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isRequired() {
        return isRequired;
    }

    @Override
    public boolean isVertical() {
        return isVertical;
    }

    @Override
    public boolean isReadOnly() {
        return isReadOnly;
    }

    @Override
    public String getValue() {
        return value;
    }

}
