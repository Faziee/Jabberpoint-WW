package Presentation;

import Composite.Slide;

import java.util.ArrayList;


/**
 * <p>Presentation.Presentation houdt de slides in de presentatie bij.</p>
 * <p>Er is slechts ��n instantie van deze klasse aanwezig.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
	private String title; // de titel van de presentatie
	private ArrayList<Slide> slides = null; // een ArrayList met de Slides
	private int currentSlideNumber = 0; // het slidenummer van de huidige Composite.Slide
	private SlideViewerComponent slideViewComponent; // de viewcomponent voor de Slides

	public Presentation()
	{
		this.slideViewComponent = null;
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent)
	{
		this.slideViewComponent = slideViewerComponent;
		clear();
	}

	public int getSize()
	{
		return this.slides.size();
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent)
	{
		this.slideViewComponent = slideViewerComponent;
	}

	// geef het nummer van de huidige slide
	public int getSlideNumber()
	{
		return this.currentSlideNumber;
	}

	// verander het huidige-slide-nummer en laat het aan het window weten.
	public void setSlideNumber(int number)
	{
		this.currentSlideNumber = number;
		if (this.slideViewComponent != null)
		{
			this.slideViewComponent.update(this, getCurrentSlide());
		}
	}

	// ga naar de vorige slide tenzij je aan het begin van de presentatie bent
	public void prevSlide() {
		if (this.currentSlideNumber > 0)
		{
			setSlideNumber(this.currentSlideNumber - 1);
	    }
	}

	// Ga naar de volgende slide tenzij je aan het einde van de presentatie bent.
	public void nextSlide()
	{
		if (this.currentSlideNumber < (slides.size()-1))
		{
			setSlideNumber(this.currentSlideNumber + 1);
		}
	}

	// Verwijder de presentatie, om klaar te zijn voor de volgende
	void clear()
	{
		this.slides = new ArrayList<>();
		setSlideNumber(-1);
	}

	// Voeg een slide toe aan de presentatie
	public void append(Slide slide)
	{
		this.slides.add(slide);
	}

	// Geef een slide met een bepaald slidenummer
	public Slide getSlide(int number)
	{
		if (number < 0 || number >= getSize())
		{
			return null;
	    }

		return this.slides.get(number);
	}

	// Geef de huidige Composite.Slide
	public Slide getCurrentSlide()
	{
		return getSlide(currentSlideNumber);
	}

	public void exit(int n)
	{
		System.exit(n);
	}
}
