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
package org.nuxeo.ecm.webengine.security.guards;

import java.security.Principal;

import org.nuxeo.common.xmap.annotation.XObject;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;
import org.nuxeo.ecm.webengine.model.Access;
import org.nuxeo.ecm.webengine.security.Guard;
import org.nuxeo.runtime.model.Adaptable;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
@XObject("isAdministrator")
public class IsAdministratorGuard implements Guard {

    protected boolean isAdministrator;

    public IsAdministratorGuard() {
        isAdministrator = true;
    }

    public IsAdministratorGuard(String isAdministrator) {
        this.isAdministrator = Boolean.parseBoolean(isAdministrator);
    }

    public IsAdministratorGuard(Access isAdministrator) {
        this.isAdministrator = isAdministrator == Access.GRANT;
    }

    public boolean check(Adaptable context) {
        Principal p = context.getAdapter(Principal.class);
        if (p instanceof NuxeoPrincipal) {
            return ((NuxeoPrincipal) p).isAdministrator() == isAdministrator;
        }
        return false;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public String toString() {
        return "IS_ADMINISTRATOR[" + isAdministrator + "]";
    }

}
