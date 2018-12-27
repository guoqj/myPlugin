package com.guo.plugins

import com.android.build.api.transform.*
import com.android.build.gradle.internal.pipeline.TransformManager
import org.gradle.api.Project
/**
 * @author guoqj
 * @version 2.5.4
 * @描述:
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/21 0021
 */

class MyTransformTest extends Transform {

    Project project

    MyTransformTest(Project project) {
        this.project = project
    }

    @Override
    String getName() {
        return MyTransformTest.simpleName
    }

    @Override
    void transform(Context context, Collection<TransformInput> inputs, Collection<TransformInput> referencedInputs, TransformOutputProvider outputProvider, boolean isIncremental) throws IOException, TransformException, InterruptedException {
        System.out.println("=======================================doPathTransform{ context=${context}, inputs=${inputs}, referencedInputs=${referencedInputs}, outputProvider=${outputProvider}, isIncremental=${isIncremental}")
    }


    @Override
    Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @Override
    Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @Override
    boolean isIncremental() {
        return false
    }
}
