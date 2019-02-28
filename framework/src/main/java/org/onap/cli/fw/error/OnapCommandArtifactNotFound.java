/*
 * Copyright 2017 Huawei Technologies Co., Ltd.
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
 */

package org.onap.cli.fw.error;

/**
 * Artifact does not exist at given path.
 *
 */
public class OnapCommandArtifactNotFound extends OnapCommandException {
    private static final long serialVersionUID = 488775545436993019L;

    private static final String ERROR_CODE = "0x21003";

    public OnapCommandArtifactNotFound(String  name, String category) {
        super(ERROR_CODE, "Artifact does not exists with given name " + name + " under category " + category);
    }
}
