package remotetest.gui2;

import java.awt.*;

public class Pair {
    public int width;
    public int height;

    public void setCenterPosition() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (Integer) screenSize.width / 2;
        height = (Integer) screenSize.height / 2;
    }
}
