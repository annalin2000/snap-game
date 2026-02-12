# 🃏 Snap Card Game

A simple 2 player Snap card game built in Java and played in the command line.

Players take turns drawing cards. If two consecutive cards share the same symbols (e.g. two Kings or two 7s), the current player must type 'snap' within 2 seconds to win.


## 🎮  How to Play

1. Run the program.
2. Choose to view instructions or start the game.
3. Enter both players' names.
4. The game automatically creates and shuffles the deck, then randomly selects who goes first.
5. Players press **ENTER** to draw cards.
6. If two consecutive cards match:
   - Type 'snap' within 2 seconds to win.
   - Incorrect or late responses result in a loss.
7. If the deck runs out without a match, the game ends in a draw.
8. After each game, enter 'y' to play again or 'n' to exit.


## 🚀 Getting Started

1. Visit: https://github.com/annalin2000/snap-game
2. Click the **`<> Code`** button.
3. Select your preferred method (HTTPS, SSH, or GitHub CLI).
4. Copy the repository URL.
5. Open **Terminal** and navigate to your desired directory.
6. Run:
```bash
git clone <repository URL>
```
7. Move into the project folder:
```bash
cd snap-game
```

8. Compile the program:

```bash
javac -d out src/main/Main.java
```

9. Run the game:

```bash
java -cp out main.Main
```

Follow the on screen prompts to begin playing.


## 🤝 Contributing

1. Fork the repository:
2. Clone your fork:

```bash
git clone https://github.com/<your-username>/snap-game.git
cd snap-game
```

3. Create a Branch

```bash
git checkout -b feature/your-feature-name
```

3. Commit and push your changes
 
```bash
git add .
git commit -m "Clear description of your change"
git push origin feature/your-feature-name
```
4. Open Pull Request
   - Go to your fork on GitHub and click Compare & Pull Request.
   - Explain clearly what you changed and why.


## 💬 Feedback

If you enjoyed the game or have suggestions for improvement, feel free to open an issue or submit a pull request.

Thanks for playing!
