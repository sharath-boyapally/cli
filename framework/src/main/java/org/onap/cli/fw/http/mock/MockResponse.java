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

package org.onap.cli.fw.http.mock;

import java.io.IOException;

import org.onap.cli.fw.error.OnapCommandFailedMocoGenerate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class MockResponse {
    private int status;
    private JsonNode json;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JsonNode getJson() {
        return json;
    }

    public void setJson(String json) throws OnapCommandFailedMocoGenerate {
        if (json.isEmpty()) {
            this.json = JsonNodeFactory.instance.objectNode();
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.json = objectMapper.readTree(json);
        } catch (IOException error) {
            throw new OnapCommandFailedMocoGenerate(null, error);
        }
    }
}