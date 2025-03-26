package FactoryMethod;

import Composite.SlideItem;
import Composite.TextItem;

public class TextItemFactory implements SlideItemFactory
{
    private final StyleFactory styleFactory;

    public TextItemFactory(StyleFactory styleFactory)
    {
        this.styleFactory = styleFactory;
    }

    @Override
    public SlideItem createSlideItem(int level, String content)
    {
        return new TextItem(level, this.styleFactory, content);
    }
}
