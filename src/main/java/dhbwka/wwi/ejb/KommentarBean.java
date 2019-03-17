 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.Stern;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */


@Stateless
public class KommentarBean extends EntityBean<Kommentar, Long> {

    public KommentarBean() {
        super(Kommentar.class);
    }
}
