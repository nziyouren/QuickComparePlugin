package com.happy.plugin.quickcompare.entity;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zhang on 2017/8/18.
 */
public class CompareObject{

    public VirtualFile compareFile;
    public Project belongProject;

    public CompareObject(VirtualFile compareFile, Project belongProject) {
        this.compareFile = compareFile;
        this.belongProject = belongProject;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof CompareObject))
            return false;
        CompareObject other = (CompareObject) obj;
        if (this.compareFile.getPath().equals(other.compareFile.getPath()) && this.belongProject.getBasePath().equals(other.belongProject.getBasePath()))
            return true;
        else {
            return false;
        }
    }
}
