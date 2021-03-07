package br.com.megastore.presentation;

import br.com.megastore.admin.Admin;
import br.com.megastore.visitor.Visitor;

public enum PresentationType {
    VISIT(new Visitor()),
    LOGIN(new Admin());

    Presentation presentation;

    PresentationType(Presentation presentation) {
        this.presentation = presentation;
    }

    public Presentation getPresentation() {
        return presentation;
    }
}
