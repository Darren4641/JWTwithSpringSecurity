package com.Controller;

import com.Jwt.JwtTokenProvider;
import com.Model.Board;
import com.Repository.BoardRepository;
import com.Service.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class BoardController extends Controller{

    private final BoardRepository boardRepository = getBoardRepository();

    public BoardController(BoardRepository boardRepository, JwtService jwtService, JwtTokenProvider jwtTokenProvider) {
        super(boardRepository, jwtService, jwtTokenProvider);
    }


    @PostMapping("/write")
        public Board writeBoard(HttpServletRequest request, @RequestBody Map<String, String> post) {
            String info = getUserInfo(request);
            Board board = Board.builder()
                    .userId(info)
                    .title(post.get("title"))
                    .context(post.get("context")).build();

            return boardRepository.save(board);
        }

}
