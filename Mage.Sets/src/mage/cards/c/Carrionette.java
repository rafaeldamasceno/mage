/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.c;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DoUnlessTargetPlayerOrTargetsControllerPaysEffect;
import mage.abilities.effects.common.ExileSourceEffect;
import mage.abilities.effects.common.ExileTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author L_J
 */
public class Carrionette extends CardImpl {

    public Carrionette(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{B}");
        this.subtype.add(SubType.SKELETON);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // {2}{B}{B}: Exile Carrionette and target creature unless that creature's controller pays {2}. Activate this ability only if Carrionette is in your graveyard.
        DoUnlessTargetPlayerOrTargetsControllerPaysEffect effect = new DoUnlessTargetPlayerOrTargetsControllerPaysEffect(new ExileTargetEffect(), new ManaCostsImpl("{2}"));
        effect.addEffect(new ExileSourceEffect());
        effect.setText("Exile {this} and target creature unless that creature's controller pays {2}. Activate this ability only if {this} is in your graveyard");
        Ability ability = new SimpleActivatedAbility(Zone.GRAVEYARD, effect, new ManaCostsImpl("{2}{B}{B}"));
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    public Carrionette(final Carrionette card) {
        super(card);
    }

    @Override
    public Carrionette copy() {
        return new Carrionette(this);
    }
}