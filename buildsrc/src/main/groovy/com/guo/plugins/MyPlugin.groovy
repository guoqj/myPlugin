package com.guo.plugins

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project;

/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/20 0020
 */

class MyPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println "------------------------"
//     def int s=   project.getTasks().size()
        def android = project.getExtensions().getByType(AppExtension)
//        extendssize.getDefaultConfig().getApplicationId()
      //  android.registerTransform(new MyTransformTest(project))
//        println "projectdddddddddddddddddd = ${project.getBuildDir()}+ddddddd=${extendssize.getTransforms().size()}"
//        project.task('transformPath') {
//            doLast {
//                System.out.println('+++++++++++++++++++++transformPath task')
//            }
//        }

    }
}
