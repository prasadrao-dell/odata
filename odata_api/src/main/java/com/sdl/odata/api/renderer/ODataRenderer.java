/**
 * Copyright (c) 2014 All Rights Reserved by the SDL Group.
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
package com.sdl.odata.api.renderer;

import com.sdl.odata.api.ODataException;
import com.sdl.odata.api.service.ODataRequestContext;
import com.sdl.odata.api.service.ODataResponse;

/**
 * OData renderer. A renderer converts data that is the result of a query or another operation into a response body
 * in the appropriate format.
 */
public interface ODataRenderer {

    /**
     * Returns a score that indicates how suitable this renderer is for rendering the response body for the specified
     * request. The score should be a number between 0 and 100 that indicates how suitable this renderer is for the
     * specified request and data. A return value of 0 means that this renderer cannot be used this request.
     *
     * @param requestContext The request context.
     * @param data The data to render.
     * @return A score that indicates how suitable this renderer is for the specified request and data;
     *      0 if this renderer cannot render the response body for this request.
     */
    int score(ODataRequestContext requestContext, Object data);

    /**
     * Renders the response body for a request.
     *
     * @param requestContext The request context.
     * @param data The data to render.
     * @param responseBuilder The response builder to which the appropriate status code, headers and body are added.
     * @throws ODataException If an error occurs while rendering.
     */
    void render(ODataRequestContext requestContext, Object data, ODataResponse.Builder responseBuilder)
            throws ODataException;
}
