package Controllers;

import Forms.AddParlayForm;
import Forms.View.AboutRaceForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormSwitcher implements ActionListener {

    private String formName;
    private AboutRaceForm aboutRaceForm;
    private AddParlayForm addParlayForm;

    public MainFormSwitcher(String formName) {
        this.formName = formName;
        this.aboutRaceForm = new AboutRaceForm();
        this.addParlayForm = new AddParlayForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.formName)
        {
            case "AboutRaceForm":
            {
                this.aboutRaceForm.setVisible(true);
            } break;
            case "AddParlayForm":
            {
                this.addParlayForm.setVisible(true);
            } break;
        }
    }

}
