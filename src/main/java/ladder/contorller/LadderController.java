package ladder.contorller;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.direction.DirectionGeneratorImpl;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Users users = createUsers();
        int numberOfUsers = users.getNumberOfUsers();

        Ladder ladder = createLadder(numberOfUsers);

        outputView.printLadderGameResult(users, ladder);
    }

    private Users createUsers() {
        List<String> userNames = inputView.readUserNames();
        List<User> users = userNames.stream()
                .map(User::new)
                .toList();

        return new Users(users);
    }

    private Ladder createLadder(int numberOfUsers) {
        List<Line> lines = createLines(numberOfUsers);
        return new Ladder(lines);
    }

    private List<Line> createLines(int numberOfUsers) {
        int ladderHeight = inputView.readLadderHeight();
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(lineGenerator.generate(numberOfUsers));
        }

        return lines;
    }
}
