package de.randi2.junittests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.randi2.model.exceptions.PersonException;
import de.randi2.model.exceptions.ZentrumException;
import de.randi2.model.fachklassen.beans.PersonBean;
import de.randi2.model.fachklassen.beans.ZentrumBean;

/**
 * TODO die get() Methoden brauchen wir nicht explizit mit eigenen Methoden zu
 * testen, da sie eigentlich bei den set() Methoden mitgetestet werden. Das ist
 * leider hier noch nicht der Fall. Man muss immer nach einem
 * set(irgendwas)Aufruf entsprechende get Methode aufrufen, und die Werte
 * vergleichen - ob das was zu setzten war, tatsaetzlich gesetzt wurde und von
 * der get methode gelifert wird.
 * 
 * Beispiel: zentrum.setAbteilung("Abteilung1");
 * assertTrue("Abteilung1",zentrum.getAbteilung());
 * 
 * 
 * @author Katharina Chruscz <kchruscz@stud.hs-heilbronn.de>
 * @version $Id$
 * 
 */
public class ZentrumBeanTest {

	private String abteilung, hausnr, institution, ort, passwort, plz, strasse;

	private int id;

	private PersonBean ansprechpartner;

	private ZentrumBean zentrum = new ZentrumBean();

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#ZentrumBean(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, de.randi2.model.fachklassen.beans.PersonBean, java.lang.String)}.
	 * @throws PersonException 
	 */
	@Test
	public void testZentrumBeanMitParametern() throws PersonException {
			id = 1;
			institution = "institution";
			abteilung = "abteilung";
			ort = "ort";
			plz = "plz";
			strasse = "strasse";
			hausnr = "hausnr";
			ansprechpartner = new PersonBean("nachname", "vorname", "Prof.",
					'm', "user@hs-heilbronn.de", "01760099334", "017600972487",
					"01760427424");
			passwort = "passwort";

			new ZentrumBean(id, institution, abteilung, ort, plz, strasse,
					hausnr, ansprechpartner, passwort);
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#ZentrumBean()}.
	 */
	@Test
	public void testZentrumBean() {
		new ZentrumBean();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getAbteilung()}.
	 */
	@Test
	public void testGetAbteilung() throws Exception {
		abteilung = zentrum.getAbteilung();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setAbteilung(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetAbteilungNormal() throws ZentrumException {
		zentrum.setAbteilung("Abteilung1");
		assertTrue("Fehler", zentrum.getAbteilung().equals("Abteilung1"));
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setAbteilung(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetAbteilungMaximal() throws ZentrumException {
		zentrum
				.setAbteilung("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setAbteilung(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetAbteilungZuKurz() throws ZentrumException {
		zentrum.setAbteilung("b");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setAbteilung(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 * @throws
	 */
	@Test(expected = ZentrumException.class)
	public void testSetAbteilungZuLang() throws ZentrumException {
		zentrum
				.setAbteilung("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getAnsprechpartner()}.
	 */
	@Test
	public void testGetAnsprechpartner() {
		ansprechpartner = zentrum.getAnsprechpartner();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setAnsprechpartner(de.randi2.model.fachklassen.beans.PersonBean)}.
	 */
	@Test
	public void testSetAnsprechpartner() {
		zentrum.setAnsprechpartner(ansprechpartner);
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getHausnr()}.
	 */
	@Test
	public void testGetHausnr() {
		hausnr = zentrum.getHausnr();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setHausnr(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetHausnr() throws ZentrumException {
		zentrum.setHausnr("453");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setHausnr(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetHausnrFalsch() throws ZentrumException {
		zentrum.setHausnr("{3s209>");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getInstitution()}.
	 */
	@Test
	public void testGetInstitution() {
		institution = zentrum.getInstitution();

	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setInstitution(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetInstitutionNormal() throws ZentrumException {

		zentrum.setInstitution("institution1");

	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setInstitution(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetInstitutionMaxLaenge() throws ZentrumException {
		zentrum
				.setInstitution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setInstitution(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetInstitutionZuKurz() throws ZentrumException {
		zentrum.setInstitution("ab");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setInstitution(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetInstitutionZuLang() throws ZentrumException {
		zentrum
				.setInstitution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getOrt()}.
	 */
	@Test
	public void testGetOrt() {
		ort = zentrum.getOrt();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setOrt(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetOrtNormal() throws ZentrumException {
		zentrum.setOrt("ort");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setOrt(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetOrtMaxLaenge() throws ZentrumException {
		zentrum.setOrt("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setOrt(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetOrtZuKurz() throws ZentrumException {
		zentrum.setOrt("a");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setOrt(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetOrtZuLang() throws ZentrumException {
		zentrum
				.setOrt("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getPasswort()}.
	 */
	@Test
	public void testGetPasswort() {
		passwort = zentrum.getPasswort();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setPasswort(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetPasswort() throws ZentrumException {
		zentrum.setPasswort("aaaaaaaa(a&_67a");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getPlz()}.
	 */
	@Test
	public void testGetPlz() {
		plz = zentrum.getPlz();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setPlz(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetPlzRichtig() throws ZentrumException {
		zentrum.setPlz("12345");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setPlz(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetPlzFalsch() throws ZentrumException {
		zentrum.setPlz("11342234111");

	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getStrasse()}.
	 */
	@Test
	public void testGetStrasse() {
		strasse = zentrum.getStrasse();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setStrasse(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetStrasseNormal() throws ZentrumException {
		zentrum.setStrasse("Strasse");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setStrasse(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test
	public void testSetStrasseMaxLaenge() throws ZentrumException {
		zentrum
				.setStrasse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setStrasse(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetStrasseZuKurz() throws ZentrumException {
		zentrum.setStrasse("a");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setStrasse(java.lang.String)}.
	 * 
	 * @throws ZentrumException
	 */
	@Test(expected = ZentrumException.class)
	public void testSetStrasseZuLang() throws ZentrumException {
		zentrum
				.setStrasse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#getId()}.
	 */
	@Test
	public void testGetId() {
		id = zentrum.getId();
	}

	/**
	 * Test method for
	 * {@link de.randi2.model.fachklassen.beans.ZentrumBean#setId(int)}.
	 */
	@Test
	public void testSetId() {
		zentrum.setId(id);
	}

}
