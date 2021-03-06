{
    $(document).ready(() => {
            let lemonsEl = $('#lemon');
            let iceEl = $('#ice');
            let sugarsEl = $('#sugar');
            let sweetenerEl = $('#sweetener');
            let honeyEl = $('#honey');
            let strawberryEl = $('#strawberry');
            let peachEl = $('#peach');
            let blueberryEl = $('#blueberry');
            let raspberryEl = $('#raspberry');
            let earningsEl = $('#earnings');
            let popBonusEl = $('#popBonus');
            let bigTreeEl = $('#addon_1');
            let radioEl = $('#addon_2');
            let signEl = $('#addon_3');
            let trashcanEl = $('#addon_4');
            let plantsEl = $('#addon_5');
            let lightsEl = $('#addon_6');
            let fridgeEl = $('#addon_7');
            let chairsEl = $('#addon_8');
            let bigTableEl = $('#addon_9');
            let fountainEl = $('#addon_10');
            let spriteIdEl = $('#spriteId');


            // console.log(bigTreeEl[0]);
            // console.log(radioEl[0]);
            // console.log(trashcanEl[0]);
            // console.log(signEl[0]);
            // console.log(plantsEl[0]);
            // console.log(lightsEl[0]);
            // console.log(fridgeEl[0]);
            // console.log(chairsEl[0]);
            // console.log(bigTableEl[0]);
            // console.log(fountainEl[0]);

            let gameScene = new Phaser.Scene('Game');


            gameScene.init = function init() {
                // current popularity rating
                this.popBonus = parseFloat(popBonusEl[0].value);
                // current addons, will show undefined if not purchased
                this.bigTree = bigTreeEl[0];
                this.radio = radioEl[0];
                this.trashCan = trashcanEl[0];
                this.sign = signEl[0];
                this.plants = plantsEl[0];
                this.lights = lightsEl[0];
                this.fridge = fridgeEl[0];
                this.chairs = chairsEl[0];
                this.bigTable = bigTableEl[0];
                this.fountain = fountainEl[0];
                // initial starting coordinates, speeds, flags, and counters
                this.kidX = 200;
                this.kidY = 155;
                this.frontStandY = 200;
                this.buyerStartX = 220;
                this.buyerStartY = 480;
                this.sellerEmotionX = 200;
                this.sellerEmotionY = 120;
                this.buyerEmotionX = 220;
                this.buyerEmotionY = 165;
                this.counter = 0;
                this.audioCounter = 0;
                this.buyerChoice = null;
                this.buyerChoiceId = null;
                this.buyerSpeed = 3;
                this.generatedBuyer = false;
                this.game.globals = new Map();
                this.spriteId = $(spriteIdEl).val();

                // console.log(lemonsEl[0].value);
                // console.log(sugarsEl[0].value);
                // console.log(iceEl[0].value);
                // console.log(sweetenerEl[0].value);
                // console.log(honeyEl[0].value);
                // console.log(strawberryEl[0].value);
                // console.log(peachEl[0].value);
                // console.log(blueberryEl[0].value);
                // console.log(raspberryEl[0].value);
                this.inventory = [
                    // 0
                    {
                        key: 'lemon',  // 0
                        amount: lemonsEl[0].value
                    },
                    {
                        key: 'sugar', // 1
                        amount: sugarsEl[0].value
                    },
                    {
                        key: 'ice', // 2
                        amount: iceEl[0].value
                    },
                    {
                        key: 'sweetener', // 3
                        amount: sweetenerEl[0].value
                    },
                    {
                        key: 'honey', // 4
                        amount: honeyEl[0].value
                    },
                    {
                        key: 'strawberry', // 5
                        amount: strawberryEl[0].value
                    },
                    {
                        key: 'peach', // 6
                        amount: peachEl[0].value
                    },
                    {
                        key: 'blueberry', // 7
                        amount: blueberryEl[0].value
                    },
                    {
                        key: 'raspberry', // 8
                        amount: raspberryEl[0].value
                    }
                ]

                this.totalEarnings = 0;
                this.kids = [
                    {
                        key: 'kid1'
                    },
                    {
                        key: 'kid2'
                    },
                    {
                        key: 'kid3'
                    },
                    {
                        key: 'kid4'
                    },
                    {
                        key: 'kid5'
                    },
                    {
                        key: 'kid6'
                    },
                    {
                        key: 'kid7'
                    },
                    {
                        key: 'kid8'
                    }
                ];

                this.people = [
                    {
                        key: 'buyer1'
                    },
                    {
                        key: 'buyer2'
                    },
                    {
                        key: 'buyer3'
                    },
                    {
                        key: 'buyer4'
                    },
                    {
                        key: 'buyer5'
                    },
                    {
                        key: 'buyer6'
                    },
                    {
                        key: 'buyer7'
                    },
                    {
                        key: 'buyer8'
                    },
                    {
                        key: 'buyer9'
                    },
                    {
                        key: 'buyer10'
                    },
                    {
                        key: 'buyer11'
                    },
                    {
                        key: 'buyer12'
                    },
                    {
                        key: 'buyer13'
                    },
                    {
                        key: 'buyer14'
                    },
                    {
                        key: 'buyer15'
                    },
                    {
                        key: 'buyer16'
                    },
                    {
                        key: 'buyer17'
                    },
                    {
                        key: 'buyer18'
                    },
                    {
                        key: 'buyer19'
                    },
                    {
                        key: 'buyer20'
                    },
                    {
                        key: 'buyer21'
                    },
                    {
                        key: 'buyer22'
                    }
                ]

                this.icons = [
                    {
                        key: 'angry'
                    },
                    {
                        key: 'blueberry'
                    },
                    {
                        key: 'deciding'
                    },
                    {
                        key: 'drop'
                    },
                    {
                        key: 'lemon'
                    },
                    {
                        key: 'money'
                    },
                    {
                        key: 'peace'
                    },
                    {
                        key: 'peach'
                    },
                    {
                        key: 'point'
                    },
                    {
                        key: 'raspberry'
                    },
                    {
                        key: 'strawberry'
                    },
                    {
                        key: 'superhappy'
                    },
                    {
                        key: 'wave'
                    }
                ]
                // regular lemons are 3x more likely to be chosen during randomizing.
                this.lemonades = [
                    {
                        key: 'lemon',
                        price: 4.0
                    },
                    {
                        key: 'lemon',
                        price: 4.0
                    },
                    {
                        key: 'lemon',
                        price: 4.0
                    },
                    {
                        key: 'strawberry',
                        price: 4.5
                    },
                    {
                        key: 'raspberry',
                        price: 6.5
                    },
                    {
                        key: 'peach',
                        price: 5.5
                    },
                    {
                        key: 'blueberry',
                        price: 5.5
                    }
                ]
            };

            gameScene.preload = function preload() {
                // Background
                this.load.image('background', '/assets/background-blank.png');
                // Kids
                this.load.image('kid1', '/assets/kids/kid-1.png');
                this.load.image('kid2', '/assets/kids/kid-2.png');
                this.load.image('kid3', '/assets/kids/kid-3.png');
                this.load.image('kid4', '/assets/kids/kid-4.png');
                this.load.image('kid5', '/assets/kids/kid-5.png');
                this.load.image('kid6', '/assets/kids/kid-6.png');
                this.load.image('kid7', '/assets/kids/kid-7.png');
                this.load.image('kid8', '/assets/kids/kid-8.png');
                // Female Buyers
                this.load.spritesheet('buyer1', '/assets/buyers/buyer-f-1.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer2', '/assets/buyers/buyer-f-2.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer3', '/assets/buyers/buyer-f-3.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer4', '/assets/buyers/buyer-f-4.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer5', '/assets/buyers/buyer-f-5.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer6', '/assets/buyers/buyer-f-6.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer7', '/assets/buyers/buyer-f-7.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer8', '/assets/buyers/buyer-f-8.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer9', '/assets/buyers/buyer-f-9.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer10', '/assets/buyers/buyer-f-10.png', {frameWidth: 32, frameHeight: 32});
                // Male Buyers
                this.load.spritesheet('buyer11', '/assets/buyers/buyer-m-1.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer12', '/assets/buyers/buyer-m-2.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer13', '/assets/buyers/buyer-m-3.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer14', '/assets/buyers/buyer-m-4.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer15', '/assets/buyers/buyer-m-5.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer16', '/assets/buyers/buyer-m-6.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer17', '/assets/buyers/buyer-m-7.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer18', '/assets/buyers/buyer-m-8.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer19', '/assets/buyers/buyer-m-9.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer20', '/assets/buyers/buyer-m-10.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer21', '/assets/buyers/buyer-m-11.png', {frameWidth: 32, frameHeight: 32});
                this.load.spritesheet('buyer22', '/assets/buyers/buyer-m-12.png', {frameWidth: 32, frameHeight: 32});
                // Load emotions
                this.load.image('angry', '/assets/emotions/angry.png');
                this.load.image('blueberry', '/assets/emotions/blueberry.png');
                this.load.image('deciding', '/assets/emotions/deciding.png');
                this.load.image('lemon', '/assets/emotions/lemon.png');
                this.load.image('peace', '/assets/emotions/peace.png');
                this.load.image('peach', '/assets/emotions/peach.png');
                this.load.image('point', '/assets/emotions/point.png');
                this.load.image('raspberry', '/assets/emotions/raspberry.png');
                this.load.image('strawberry', '/assets/emotions/strawberry.png');
                this.load.image('superhappy', '/assets/emotions/superhappy.png');
                this.load.image('wave', '/assets/emotions/wave.png');
                this.load.image('money', '/assets/emotions/money.png');
                this.load.image('drop', '/assets/emotions/drop.png');
                this.load.image('nostock', '/assets/emotions/nostock.png');
                // Load addons
                this.load.image('bigtable', '/assets/addons/bigtable.png');
                this.load.image('bigtree', '/assets/addons/bigtree.png');
                this.load.image('chairs', '/assets/addons/chairs.png');
                this.load.image('fountain', '/assets/addons/fountain.png');
                this.load.image('fridge', '/assets/addons/fridge.png');
                this.load.image('lights', '/assets/addons/lights.png');
                this.load.image('plant', '/assets/addons/plant.png');
                this.load.image('radio', '/assets/addons/radio.png');
                this.load.image('sign', '/assets/addons/sign.png');
                this.load.image('trashcan', '/assets/addons/trashcan.png');
                // Load audio
                this.load.audio('backgroundAudio', '/assets/audio/background-song-v2.mp3');
                this.load.audio('moneyAudio', '/assets/audio/money-sound-v2.mp3');
                this.load.audio('sadAudio', '/assets/audio/sad-sound-v2.mp3');
                // Load audio sprite
                this.load.image('sound', '/assets/audio/volume-up-solid.png');
                this.load.image('noSound', '/assets/audio/volume-mute-solid.png');
            };

            gameScene.create = function create() {
                // Set background
                this.add.sprite(0, 0, 'background').setOrigin(0,0);
                // Set addons
                if (this.bigTree !== undefined) {
                    this.add.sprite(187,70, 'bigtree');
                }
                if (this.bigTable !== undefined) {
                    this.add.sprite(105, 135, 'bigtable');
                }
                if (this.chairs !== undefined) {
                    this.add.sprite(105, 230, 'chairs');
                }
                if (this.fountain !== undefined) {
                    this.add.sprite(315, 335, 'fountain');
                }
                if (this.fridge !== undefined) {
                    this.add.sprite(230, 125, 'fridge');
                }
                if (this.lights !== undefined) {
                    this.add.sprite(20, 115, 'lights');
                    this.add.sprite(300, 115, 'lights');
                }
                if (this.plants !== undefined) {
                    this.add.sprite(170, 180, 'plant');
                    this.add.sprite(245, 180, 'plant');
                }
                if (this.radio !== undefined) {
                    this.add.sprite(255, 125, 'radio');
                }
                if (this.sign !== undefined) {
                    this.add.sprite(270, 280, 'sign');
                }
                if (this.trashCan !== undefined) {
                    this.add.sprite(190, 135, 'trashcan');
                    this.add.sprite(154, 185, 'trashcan');
                }

                // set initial flags for all buyer sprites
                for (let i = 0; i < this.people.length; i++) {
                    let buyer = this.people[i];
                    this.game.globals.set(buyer.key, this.add.sprite(30 * (i + 1), 30 * (i + 1), buyer.key));
                    this.game.globals.get(buyer.key).alpha = 0;
                    this.game.globals.get(buyer.key).walkedUp = false;
                    this.game.globals.get(buyer.key).walkedLeft = false;
                    this.game.globals.get(buyer.key).walkedBack = false;
                    this.game.globals.get(buyer.key).didTransaction = false;
                    this.game.globals.get(buyer.key).doneDeciding = false;
                    this.game.globals.get(buyer.key).boughtLemonade = false;
                    this.game.globals.get(buyer.key).gotAngry = false;
                    this.anims.create({
                            key: buyer.key + 'down',
                            frames: this.anims.generateFrameNumbers(buyer.key, {
                                start: 0,
                                end: 2
                            }),
                            frameRate: 10,
                            repeat: -1
                        }
                    );

                    this.anims.create({
                        key: buyer.key + 'left',
                        frames: this.anims.generateFrameNumbers(buyer.key, {
                            start: 3,
                            end: 5
                        }),
                        frameRate: 10,
                        repeat: -1
                    });

                    this.anims.create({
                        key: buyer.key + 'right',
                        frames: this.anims.generateFrameNumbers(buyer.key, {
                            start: 6,
                            end: 8
                        }),
                        frameRate: 10,
                        repeat: -1
                    });

                    this.anims.create({
                        key: buyer.key + 'up',
                        frames: this.anims.generateFrameNumbers(buyer.key, {
                            start: 9,
                            end: 11
                        }),
                        frameRate: 10,
                        repeat: -1
                    });
                }

                // add the sprite for the seller
                this.add.sprite(this.kidX, this.kidY, 'kid' + this.spriteId);
                // add text box for counting earnings
                this.earningsText = this.add.text(250, 0, 'Total Earnings:$0', {
                    fontFamily: 'Courier',
                    fontSize: 22,
                    color: 'rgba(38, 76, 81, 1)',
                    backgroundColor: 'rgba(255, 178, 2, .7)'
                });
                // add popularity bonus text box
                this.popularityText = this.add.text(250, 24, 'Popularity Rating:+' + this.popBonus + '%', {
                    fontFamily: 'Courier',
                    fontSize: 22,
                    color: 'rgba(38, 76, 81, 1)',
                    backgroundColor: 'rgba(255, 178, 2, .7)'
                });

                // add buyer and seller emotions
                this.buyerEmotion = this.add.sprite(this.buyerEmotionX, this.buyerEmotionY, 'deciding');
                this.sellerEmotion = this.add.sprite(this.sellerEmotionX, this.sellerEmotionY, 'money');
                this.sellerEmotion.setInteractive();
                this.tween = this.tweens.add({
                    targets: this.sellerEmotion,
                    scaleX: 1.2,
                    scaleY: 1.2,
                    duration: 500,
                    paused: true,
                    loop: 10,
                    yoyo: true
                });
                // initially hide the emotions until called on
                this.buyerEmotion.alpha = 0;
                this.sellerEmotion.alpha = 0;
                // add sounds
                this.backgroundAudio = this.sound.add('backgroundAudio');
                this.moneyAudio = this.sound.add('moneyAudio');
                this.sadAudio = this.sound.add('sadAudio');
                this.backgroundAudio.volume = .4;
                this.moneyAudio.volume = .4;
                this.sadAudio.volume = .2;
                this.backgroundAudio.loop = true;
                this.backgroundAudioPlaying = true;
                this.backgroundAudio.play();
                // add audio icon
                this.audioIcon = this.add.sprite(560, 445, 'sound');
                this.audioIcon.setInteractive();
            };


            gameScene.update = function update() {
                this.audioIcon.on('pointerdown', function (pointer) {
                    if (!this.backgroundAudioPlaying && this.audioCounter === 0) {
                        this.audioIcon.setTexture('sound');
                        this.backgroundAudioPlaying = true;
                        this.backgroundAudio.volume = .4;
                        this.moneyAudio.volume = .4;
                        this.sadAudio.volume = .2;
                        this.audioCounter++;
                    } else if (this.backgroundAudioPlaying && this.audioCounter === 0){
                        this.audioIcon.setTexture('noSound');
                        this.backgroundAudioPlaying = false;
                        this.backgroundAudio.volume = 0;
                        this.moneyAudio.volume = 0;
                        this.sadAudio.volume = 0;
                        this.audioCounter++;
                    }
                }, this);


                // console.log(this.game.globals.get(key));
                if (!this.generatedBuyer) {
                    this.generateBuyer();
                }
                // user was generated
                if (this.generatedBuyer) {
                    this.walkPath(this.game.globals.get(this.key));
                }
                this.audioCounter = 0;
            }


            gameScene.generateBuyer = function () {
                // if there is no generated buyer, then generate a random one
                if (!this.generatedBuyer) {
                    console.log("generating player");
                    let people = this.people;
                    let id = Math.floor(Math.random() * people.length);
                    this.key = people[id].key;
                    console.log("here");
                    console.log(this.key);
                    console.log(this.game.globals.get(this.key));
                    // RESET THE BUYER STATUS
                    this.game.globals.get(this.key).alpha = 1;
                    this.game.globals.get(this.key).walkedUp = false;
                    this.game.globals.get(this.key).walkedLeft = false;
                    this.game.globals.get(this.key).walkedBack = false;
                    this.game.globals.get(this.key).didTransaction = false;
                    this.game.globals.get(this.key).doneDeciding = false;
                    this.game.globals.get(this.key).boughtLemonade = false;
                    this.game.globals.get(this.key).gotAngry = false;
                    this.game.globals.get(this.key).x = this.buyerStartX;
                    this.game.globals.get(this.key).y = this.buyerStartY;
                    this.buyerEmotion.x = this.buyerEmotionX;
                    this.buyerEmotion.y = this.buyerEmotionY;
                    this.counter = 0;

                }
                // user was generated
                this.generatedBuyer = true;
            }

            gameScene.walkPath = function (buyer) {
                // walk up y:190 is in front of stand, if he has not walked up
                if (!buyer.walkedUp) {
                    this.walkForward(buyer);
                    // console.log("walking up");
                }
                // buyer.walkedUp = true at this point

                // Do transaction
                if (buyer.walkedUp && !buyer.boughtLemonade && !buyer.gotAngry) {
                    this.doTransaction(buyer);
                    console.log("buying");
                }

                if (buyer.walkedUp && buyer.boughtLemonade && !buyer.walkedLeft && this.counter === 1) {
                    this.makeLemonade(this.buyerChoice);
                    this.totalEarnings = this.increaseEarnings(this.lemonades[this.buyerChoiceId].price);
                    console.log(this.totalEarnings);
                }
                // buyer.boughtLemonade = true at this point

                // Once he walked up, he can walk left to start leaving
                if (buyer.walkedUp && (buyer.boughtLemonade || buyer.gotAngry) && !buyer.walkedLeft) {
                    this.walkLeft(buyer);
                    console.log("walking left");
                }
                // buyer.walkedLeft = true at this point

                // Walk back and exit scene
                if (buyer.walkedUp && buyer.walkedLeft && (buyer.boughtLemonade || buyer.gotAngry) && !buyer.walkedBack) {
                    this.walkBack(buyer);
                    console.log("walking back");
                }
            };

            // Buyer walking up
            gameScene.walkForward = function (buyer) {
                if (buyer.y >= this.frontStandY) {
                    buyer.anims.play(this.key + 'up', true);
                    buyer.y -= this.buyerSpeed;
                }
                if (buyer.y <= this.frontStandY) {
                    buyer.anims.play(this.key + 'up');
                    buyer.walkedUp = true;
                }
            };

            // Buyer walking left
            gameScene.walkLeft = function (buyer) {
                if (buyer.x >= 190) {
                    this.buyerEmotion.x -= this.buyerSpeed;
                    buyer.anims.play(this.key + 'left', true);
                    buyer.x -= this.buyerSpeed;
                }
                if (buyer.x <= 190) {
                    buyer.walkedLeft = true;
                }
            };
            // Buyer walking back
            gameScene.walkBack = function (buyer) {
                if (buyer.y <= 480) {
                    this.buyerEmotion.y += this.buyerSpeed;
                    buyer.anims.play(this.key + 'down', true);
                    buyer.y += this.buyerSpeed;
                }
                if (buyer.y >= 480) {
                    // remove sprite once exited scene
                    this.buyerEmotion.alpha = 0;
                    this.sellerEmotion.alpha = 0;
                    // buyer.disableBody(true, true);
                    buyer.alpha = 0;
                    buyer.walkedBack = true;
                    // reset the generated buyer value to false to generate a new one on update
                    this.generatedBuyer = false;
                }
            };

            gameScene.doTransaction = function (buyer) {
                buyer.anims.play(this.key + 'up', false);

                // do thinking
                if (!buyer.doneDeciding) {
                    this.buyerEmotion.setTexture('deciding');
                    this.buyerEmotion.alpha = 1;

                    this.time.delayedCall(1500, function () {
                        buyer.doneDeciding = true;
                    }, [], this);
                    // console.log("deciding");
                }

                if (buyer.doneDeciding && !buyer.boughtLemonade && !buyer.gotAngry && this.counter === 0) {
                    this.counter++;
                    this.doThinking();
                    if (this.canPurchase(this.buyerChoice)) {
                        this.sellerEmotion.setTexture('money');
                    } else {
                        this.sellerEmotion.setTexture('nostock');
                    }

                    this.buyerEmotion.setTexture(this.buyerChoice);
                    this.sellerEmotion.alpha = 1;
                    this.tween.play();
                    // if buyer has not bought a lemonade then wait until he purchases one
                    if (!buyer.boughtLemonade && !buyer.gotAngry) {
                        // sold a lemonade

                        this.sellerEmotion.on('pointerdown', function (pointer) {
                            // console.log("clicked money");
                            // stop the seller's emotion
                            if (this.canPurchase(this.buyerChoice)) {
                                this.sellerEmotion.setTexture('superhappy');
                                this.buyerEmotion.setTexture('wave');
                                // this.tween.restart();
                                this.time.delayedCall(2000, function () {
                                    this.sellerEmotion.setTexture('peace');
                                }, [], this);
                                buyer.boughtLemonade = true;
                            }

                        }, gameScene);

                        // if 10 seconds pass and user did not click the money button, then seller leaves angry
                        this.time.delayedCall(3500, function () {
                            if (!buyer.boughtLemonade) {
                                console.log("im angry");
                                this.sellerEmotion.setTexture('drop');
                                this.buyerEmotion.setTexture('angry');
                                this.sadAudio.play();
                                buyer.gotAngry = true;
                            }
                        }, [], gameScene);
                    }
                }
            };

            gameScene.increaseEarnings = function (earnings) {
                let bonus = (this.popBonus + 100) / 100;
                let newTotal = parseFloat(this.totalEarnings) + (earnings * bonus);
                this.earningsText.setText('Total Earnings:$' + newTotal.toFixed(2));
                earningsEl[0].value =  parseFloat(newTotal).toFixed(2);
                this.moneyAudio.play();
                this.counter++;
                return newTotal;
            };

            gameScene.doThinking = function () {
                let id = Math.floor(Math.random() * 7);
                this.buyerChoice = this.lemonades[id].key;
                this.buyerChoiceId = id;
            };

            gameScene.canPurchase = function (lemonade) {
                switch (lemonade) {
                    case 'lemon':
                        return !((this.inventory[0].amount < 2) || (this.inventory[1].amount < 2) || (this.inventory[2].amount < 2));
                    case 'strawberry':
                        return !((this.inventory[0].amount < 1) || (this.inventory[1].amount < 2) || (this.inventory[2].amount < 2) || (this.inventory[5].amount < 3));
                    case 'blueberry':
                        return !((this.inventory[0].amount < 1) || (this.inventory[4].amount < 1) || (this.inventory[2].amount < 2) || (this.inventory[3].amount < 1) || (this.inventory[7].amount < 8));
                    case 'peach':
                        return !((this.inventory[0].amount < 1) || (this.inventory[4].amount < 2) || (this.inventory[2].amount < 2) || (this.inventory[6].amount < 1));
                    case 'raspberry':
                        return !((this.inventory[0].amount < 1) || (this.inventory[1].amount < 1) || (this.inventory[2].amount < 2) || (this.inventory[3].amount < 1) || (this.inventory[8].amount < 8));
                    default:
                        console.log("defaulting");
                        return true;
                }
            }

            gameScene.makeLemonade = function (lemonade) {
                // console.log(lemonade);
                // console.log(this.inventory[0].amount);
                // console.log(this.inventory[1].amount);
                // console.log(this.inventory[2].amount);
                // console.log(this.inventory[3].amount);
                // console.log(this.inventory[4].amount);
                // console.log(this.inventory[5].amount);
                // console.log(this.inventory[6].amount);
                // console.log(this.inventory[7].amount);
                // console.log(this.inventory[8].amount);
                // you have enough ingredients so reduce the inventory and make the sale!
                if (lemonade === 'lemon') {
                    this.inventory[0].amount -= 2;
                    this.inventory[1].amount -= 2;
                    this.inventory[2].amount -= 2;
                    console.log(this.inventory[0].amount);
                    console.log(this.inventory[1].amount);
                    console.log(this.inventory[2].amount);
                    lemonsEl[0].value -= 2;
                    sugarsEl[0].value -= 2;
                    iceEl[0].value -= 2;
                } else if (lemonade === 'strawberry') {
                    this.inventory[0].amount -= 1;
                    this.inventory[1].amount -= 2;
                    this.inventory[2].amount -= 2;
                    this.inventory[5].amount -= 3;
                    lemonsEl[0].value -= 1;
                    sugarsEl[0].value -= 2;
                    iceEl[0].value -= 2;
                    strawberryEl[0].value -= 3;
                } else if (lemonade === 'blueberry') {
                    this.inventory[0].amount -= 1;
                    this.inventory[4].amount -= 1;
                    this.inventory[2].amount -= 2;
                    this.inventory[3].amount -= 1;
                    this.inventory[7].amount -= 8;
                    lemonsEl[0].value -= 1;
                    honeyEl[0].value -= 1;
                    iceEl[0].value -= 2;
                    sweetenerEl[0].value -= 1;
                    blueberryEl[0].value -= 8;
                } else if (lemonade === 'peach') {
                    this.inventory[0].amount -= 1;
                    this.inventory[4].amount -= 2;
                    this.inventory[2].amount -= 2;
                    this.inventory[6].amount -= 1;
                    lemonsEl[0].value -= 1;
                    honeyEl[0].value -= 2;
                    iceEl[0].value -= 2;
                    peachEl[0].value -= 1;
                } else if (lemonade === 'raspberry') {
                    this.inventory[0].amount -= 1;
                    this.inventory[1].amount -= 1;
                    this.inventory[2].amount -= 2;
                    this.inventory[3].amount -= 1;
                    this.inventory[8].amount -= 8;
                    lemonsEl[0].value -= 1;
                    sugarsEl[0].value -= 1;
                    iceEl[0].value -= 2;
                    sweetenerEl[0].value -= 1;
                    raspberryEl[0].value -= 8;
                }

            }

            let config = {
                type: Phaser.AUTO,
                width: 600,
                height: 480,
                parent: 'lemonade-game',
                physics: {
                    default: 'arcade',
                    arcade: {
                        gravity: {},
                        debug: false
                    }
                },
                scene: gameScene
            };

            let game = new Phaser.Game(config);
        }
    )
}