package com.robot.utility;

import com.robot.exception.InvalidGameRobotException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameCommandReaderTest {

    private GameCommandReader reader;

    @BeforeEach
    void setup() {
        reader = new GameCommandReader();
    }

    @Test
    public void testReadFromFileNotFound() {
        Exception exception = assertThrows(InvalidGameRobotException.class, ()->reader.processFile(new File("abc.txt")));
        assertEquals("File is not found", exception.getMessage());
    }

    @Test
    public void testReadFromFileNotAllowNull() {
        Exception exception = assertThrows(InvalidGameRobotException.class, ()->reader.processFile(null));
        assertEquals("File is not allow null", exception.getMessage());
    }

    @Test
    public void testReadFromValidFile() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("input-data.txt");
        List<String> resultList = reader.processFile(new File(resource.toURI()));
        assertEquals(resultList.size(), 3);
        assertEquals("0,1,NORTH", resultList.get(0));
        assertEquals("0,0,WEST", resultList.get(1));
        assertEquals("3,3,NORTH", resultList.get(2));
    }
}
