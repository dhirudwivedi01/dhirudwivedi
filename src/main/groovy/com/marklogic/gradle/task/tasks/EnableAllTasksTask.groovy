/*
 * Copyright (c) 2023 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.marklogic.gradle.task.tasks

import com.marklogic.gradle.task.MarkLogicTask
import com.marklogic.mgmt.resource.tasks.TaskManager
import org.gradle.api.tasks.TaskAction

class EnableAllTasksTask extends MarkLogicTask {

	@TaskAction
	void enableAllTasks() {
		String group = project.hasProperty("mlGroupName") ? project.property("mlGroupName") : "Default"
		println "Enabling all scheduled tasks in group: " + group
		new TaskManager(getManageClient(), group).enableAllTasks()
		println "Finished enabling all scheduled tasks in group: " + group
	}
}
