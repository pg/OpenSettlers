package soc.gwtClient.main;

import soc.gwtClient.game.ICenterWidget;

import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Panel;

public class WikiPanel extends LayoutPanel implements ICenterWidget
{
    private Frame frame;

    public WikiPanel()
    {
        frame = new Frame(
                "https://sourceforge.net/apps/mediawiki/opensettlers/index.php?title=Main_Page");
        frame.setWidth("100%");
        frame.setHeight("100%");
        // initWidget(frame);
        this.add(frame);
    }

    @Override
    public Panel getRootWidget()
    {
        return this;
    }

}
