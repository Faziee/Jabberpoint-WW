package FactoryMethod;

import Composite.BitmapItem;
import Composite.SlideItem;

public class BitmapItemFactory implements SlideItemFactory
{
    private final StyleFactory styleFactory;

    public BitmapItemFactory(StyleFactory styleFactory)
    {
        this.styleFactory = styleFactory;
    }

    @Override
    public SlideItem createSlideItem(int level, String content)
    {
        return new BitmapItem(level, this.styleFactory, content);
    }
}
