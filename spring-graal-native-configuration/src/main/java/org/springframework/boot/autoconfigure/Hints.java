/*
 * Copyright 2020 the original author or authors.
 *
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
 */
package org.springframework.boot.autoconfigure;

import org.springframework.graal.extension.NativeImageHint;
import org.springframework.graal.extension.NativeImageConfiguration;
import org.springframework.graal.extension.TypeInfo;
import org.springframework.graal.type.AccessBits;

@NativeImageHint(typeInfos = { @TypeInfo(types = { AutoConfigureAfter.class, AutoConfigureOrder.class,
		AutoConfigurationPackage.class }, access = AccessBits.CLASS | AccessBits.PUBLIC_METHODS) })
// TODO why isn't this one pulled in via @EnableAutoConfiguration handling?
@NativeImageHint(typeInfos = { @TypeInfo(types = { AutoConfigurationImportSelector.class,
		AutoConfigurationPackages.class, AutoConfigurationPackages.Registrar.class,
		AutoConfigurationPackages.BasePackages.class,
		EnableAutoConfiguration.class,SpringBootApplication.class
		}, typeNames = {
				"org.springframework.boot.autoconfigure.AutoConfigurationImportSelector$AutoConfigurationGroup" }) })
public class Hints implements NativeImageConfiguration {
}
