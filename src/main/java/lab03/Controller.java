package lab03;

import lab03.model.Date;
import lab03.model.DateStorage;

public class Controller {
    private View view;
    private DateStorage dateStorage;

    public Controller(View view, DateStorage dateStorage) {
        this.view = view;
        this.dateStorage = dateStorage;
    }

    public void run() {
        while (true) {
            switch (view.requestAction()) {
                case 1:
                    addDate();
                    break;

                case 2:
                    removeDate();
                    break;

                case 3:
                    listDate();
                    break;

                case 4:
                    return;

                default:
                    view.showMessage("Invalid action!");
                    break;
            }
        }
    }

    private void addDate() {
        Date date = new Date();

        try {
            date.setYear(Integer.parseInt(view.requestProperty(("Year"))));
            date.setMonth(Integer.parseInt(view.requestProperty(("Month"))));
            date.setDay(Integer.parseInt(view.requestProperty("Day")));
        } catch (NumberFormatException e) {
            view.showMessage("Invalid number");
            return;
        }

        dateStorage.add(date);
    }

    private void removeDate() {
        int i = view.requestIndex();
        if (i < 0 || i >= dateStorage.size()) {
            view.showMessage("Invalid index!");
            return;
        }
        dateStorage.remove(i);
    }

    private void listDate() {
        view.showList(dateStorage.fetchList());
    }
}
